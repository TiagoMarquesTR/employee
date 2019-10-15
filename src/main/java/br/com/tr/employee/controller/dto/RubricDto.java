package br.com.tr.employee.controller.dto;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.sun.istack.Nullable;

import br.com.tr.employee.model.Rubric;

public class RubricDto {

    @Id
    @GeneratedValue(generator = "uuid2")
    @Nullable
    private UUID rubricId;
    private UUID clientId;
    private String name;
    private char type;
    private char unit;
    private char consistsNetPay;
    private char inssBase;
    private char fgtsBase;
    private char irrfBase;
    private char overtimeBase;
    private int calculationBase;
    private double rate;
    
    public RubricDto() {
    	    	
    }
    	
	public RubricDto(Rubric rubric) {
		this.rubricId = rubric.getRubricId();
		this.clientId = rubric.getClientId();
		this.name = rubric.getName();
		this.type = rubric.getType();
		this.unit = rubric.getUnit();
		this.consistsNetPay = rubric.getConsistsNetPay();
		this.inssBase = rubric.getInssBase();
		this.fgtsBase = rubric.getFgtsBase();
		this.irrfBase = rubric.getIrrfBase();
		this.overtimeBase = rubric.getOvertimeBase();
		this.calculationBase = rubric.getCalculationBase();
		this.rate = rubric.getRate();
	}
	
	public static List<RubricDto> convert(List<Rubric> rubrics){
		return rubrics.stream().map(RubricDto::new).collect(Collectors.toList());
	}

	public UUID getRubricId() {
		return rubricId;
	}

	public void setRubricId(UUID rubricId) {
		this.rubricId = rubricId;
	}

	public UUID getClientId() {
		return clientId;
	}

	public void setClientId(UUID clientId) {
		this.clientId = clientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public char getUnit() {
		return unit;
	}

	public void setUnit(char unit) {
		this.unit = unit;
	}

	public char getConsistsNetPay() {
		return consistsNetPay;
	}

	public void setConsistsNetPay(char consistsNetPay) {
		this.consistsNetPay = consistsNetPay;
	}

	public char getInssBase() {
		return inssBase;
	}

	public void setInssBase(char inssBase) {
		this.inssBase = inssBase;
	}

	public char getFgtsBase() {
		return fgtsBase;
	}

	public void setFgtsBase(char fgtsBase) {
		this.fgtsBase = fgtsBase;
	}

	public char getIrrfBase() {
		return irrfBase;
	}

	public void setIrrfBase(char irrfBase) {
		this.irrfBase = irrfBase;
	}

	public char getOvertimeBase() {
		return overtimeBase;
	}

	public void setOvertimeBase(char overtimeBase) {
		this.overtimeBase = overtimeBase;
	}

	public int getCalculationBase() {
		return calculationBase;
	}

	public void setCalculationBase(int calculationBase) {
		this.calculationBase = calculationBase;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
    
    
    
}
