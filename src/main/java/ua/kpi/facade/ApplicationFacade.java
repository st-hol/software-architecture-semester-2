package ua.kpi.facade;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ua.kpi.command.Command;
import ua.kpi.command.operations.AbsCommand;
import ua.kpi.command.operations.AddCommand;
import ua.kpi.command.operations.MultiplyCommand;
import ua.kpi.command.operations.NoActionCommand;
import ua.kpi.domain.CalculationRequest;
import ua.kpi.domain.CalculationResult;
import ua.kpi.domain.ComplexNumber;
import ua.kpi.dto.TwoOperandsDto;
import ua.kpi.service.CalculationService;
import ua.kpi.service.impl.CalculationRequestService;
import ua.kpi.service.impl.CalculationResultService;
import ua.kpi.service.impl.ComplexNumberService;
import ua.kpi.type.ActionCode;


@Component
public class ApplicationFacade {

    private Map<ActionCode, Command> commands;

    private CalculationService calculationService;
    private ComplexNumberService complexNumberService;
    private CalculationResultService calculationResultService;
    private CalculationRequestService calculationRequestService;
    private AbsCommand absCommand;
    private AddCommand addCommand;
    private MultiplyCommand multiplyCommand;

    @Autowired
    public ApplicationFacade(CalculationService calculationService,
                             ComplexNumberService complexNumberService,
                             CalculationResultService calculationResultService,
                             CalculationRequestService calculationRequestService, AbsCommand absCommand,
                             AddCommand addCommand, MultiplyCommand multiplyCommand) {
        this.calculationService = calculationService;
        this.complexNumberService = complexNumberService;
        this.calculationResultService = calculationResultService;
        this.calculationRequestService = calculationRequestService;
        this.absCommand = absCommand;
        this.addCommand = addCommand;
        this.multiplyCommand = multiplyCommand;
    }

    @PostConstruct
    public void initCommands() {
        commands = new EnumMap<>(ActionCode.class);
        commands.put(ActionCode.ABS, absCommand);
        commands.put(ActionCode.ADD, addCommand);
        commands.put(ActionCode.MUL, multiplyCommand);
    }

    public void deleteResultById(Long id) {
        calculationResultService.deleteById(id);
    }

    public List<CalculationResult> populateAllResults() {
        return calculationResultService.findAll();
    }

    public CalculationResult populateResultById(Long id) {
        return calculationResultService.findById(id);
    }

    public CalculationResult updateResult(CalculationResult calculationResult) {
        return calculationResultService.save(calculationResult);
    }

    public Map<ActionCode, Command> getCommands() {
        return commands;
    }

    public CalculationResult saveResult(CalculationResult calculationResult) {
        return calculationResultService.save(calculationResult);
    }

    public CalculationRequest saveRequest(CalculationRequest calculationRequest) {
        return calculationRequestService.save(calculationRequest);
    }


    @Transactional
    public void calculateResult(TwoOperandsDto dto) {
        ActionCode actionCode = ActionCode.fromValue(dto.getActionTaken().toUpperCase());
        Command command = commands.getOrDefault(actionCode, new NoActionCommand());
        if (command.getClass() == NoActionCommand.class) {
            return;
        }
        ComplexNumber firstOperand = new ComplexNumber(dto.getR1(), dto.getI1());
        ComplexNumber secondOperand = new ComplexNumber(dto.getR2(), dto.getI2());

        CalculationRequest calculationRequest = new CalculationRequest();
        List<ComplexNumber> operands = Stream.of(firstOperand, secondOperand)
                .filter(complexNumber -> complexNumber.getI() != null && complexNumber.getR() != null)
                .collect(Collectors.toList());
        calculationRequest.setComplexNumbers(operands);
        calculationRequest.setActionCode(actionCode);
        this.saveRequest(calculationRequest);

        ComplexNumber result = command.execute(calculationRequest);
        CalculationResult calculationResult = new CalculationResult();
        calculationResult.setComplexNumber(result);
        calculationResult.setCalculationRequest(calculationRequest);
        this.saveResult(calculationResult);

        operands.forEach(operand -> {
            operand.setCalculationRequest(calculationRequest);
            operand.setCalculationResult(calculationResult);
            complexNumberService.save(operand);
        });
    }
}
