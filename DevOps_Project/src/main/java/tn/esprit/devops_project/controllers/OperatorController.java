package tn.esprit.devops_project.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.services.Iservices.IOperatorService;

import java.util.List;

@RestController
@AllArgsConstructor
public class OperatorController {

	IOperatorService operatorService;
	
	@GetMapping("/operator")
	public List<Operator> getOperators() {
		return operatorService.retrieveAllOperators();
	}

	@GetMapping("/operator/{operatorId}")
	public Operator retrieveoperator(@PathVariable Long operatorId) {
		return operatorService.retrieveOperator(operatorId);
	}

	@PostMapping("/operator")
	public Operator addOperator(@RequestBody Operator operator) {
		return operatorService.addOperator(operator);
	}

	@DeleteMapping("/operatot/{operatorId}")
	public void removeOperator(@PathVariable Long operatorId) {
		operatorService.deleteOperator(operatorId);
	}

	@PutMapping("/operator")
	public Operator modifyOperateur(@RequestBody Operator operator) {
		return operatorService.updateOperator(operator);
	}

	
}
