package com.expense.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.expense.dto.ExpenseDTO;
import com.expense.entity.Expense;

/*Expense mapper class implemented all required method from ModelMapper class
 * so that we can implement this class in controller class without hard coding it repeatedly
 * */
@Component
public class ExpenseMapper{
	
	@Autowired
    private ModelMapper modelMapper;
	
	/*this method gives stored data from model to modeldto
	 * Here data will transfer from expense to expensedto
	 */
	public ExpenseDTO modelToDTOMap(Expense model) {
		return modelMapper.map(model, ExpenseDTO.class);
	}
	
	/*this method gives stored data from modeldto to model
	 * Here data will transfer from expensedto expense object
	 */

	public Expense dtoToModelMap(ExpenseDTO dto) {
		return modelMapper.map(dto, Expense.class);
	}

	/*this method gives stored data from model to modeldto
	 * Here list of data will transfer from expense to expensedto
	 */
	public List<ExpenseDTO> modelToDTOList(List<Expense> modelList) {
		return modelList.stream()
				.map(material -> modelToDTOMap(material))
				.collect(Collectors.toList());
	}
	

	/*this method gives stored data from modeldto to model
	 * Here list of data will transfer from expensedto expense object
	 */
	
	public List<Expense> dtoToModelList(List<ExpenseDTO> dtoList) {
		return dtoList.stream()
				.map(materialDTO -> dtoToModelMap(materialDTO))
				.collect(Collectors.toList());
	}


}
