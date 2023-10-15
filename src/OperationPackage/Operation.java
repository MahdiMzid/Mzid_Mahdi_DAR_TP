package OperationPackage;

import java.io.Serializable;

public class Operation implements Serializable{
	public Operation(int op1, int op2, int result, char operation) {
		super();
		this.op1 = op1;
		this.op2 = op2;
		this.result = result;
		this.operation = operation;
	}
	private int op1,op2,result;
	private char operation;
	public int getOp1() {
		return op1;
	}
	public void setOp1(int op1) {
		this.op1 = op1;
	}
	public int getOp2() {
		return op2;
	}
	public void setOp2(int op2) {
		this.op2 = op2;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public char getOperation() {
		return operation;
	}
	public void setOperation(char operation) {
		this.operation = operation;
	}

}
