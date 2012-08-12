package com.bip.common.util;

/**
 * FormulaCalculator.java
 *
 * Created on 2007��9��18��, ����11:40
 * @title ת���ַ������ʽΪ��ѧ��ʽ��������
 * @description ת���ַ������ʽΪ��ѧ��ʽ��������
 * ע��:Ϊ�����ָ��ţ����ʹ��#�������
 * ʹ�÷���:
 * FormulaCalculator calculator=new FormulaCalculator();
 * calculator.getResult("10.23#20.67*(5.12+7.82)/2",2);
 * v1.0.0 created by chenfc
 *
 */

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormulaCalculator {
	private boolean isRightFormat = true;
	public String DIVISOR_EQUALS_ZERO = "0.0";// ����Ϊ��ʱ�ķ���ֵ

	/**
	 * Ϊ�����ָ��ţ����ʹ��-�������
	 * 
	 * @param formula
	 *            �ַ������ʽ
	 * @return ���ع�ʽ������
	 */
	public double getResult(String formula) {
		double returnValue = 0;
		try {
			returnValue = doAnalysis(formula);
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
			System.out.println("��ʽ��ʽ��������:" + formula);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!isRightFormat) {
			System.out.println("��ʽ��ʽ��������:" + formula);
		}
		return returnValue;
	}

	/**
	 * ����BigDecimal.ROUND_HALF_UP��ʽ����ָ�����ȵ�������
	 * 
	 * @param formula
	 *            ��ʽ
	 * @param decimalPlace
	 *            Ҫ������С��λ��
	 * @return ���ع�ʽ������
	 */
	public String getResult(String formula, int decimalPlace) {
		return getResult(formula, decimalPlace, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * ����ָ�����ȼ���ȥβ���Ĳ��Ե�������
	 * 
	 * @param formula
	 *            ��ʽ
	 * @param decimalPlace
	 *            Ҫ������С��λ��
	 * @param roundMethod
	 *            ��ȥβ���Ĳ��� ��ȡֵ��BigDecimal.ROUND_HALF_UP
	 *            BigDecimal.ROUND_HALF_DOWN���BigDecimal
	 * @return ���ع�ʽ������
	 */
	public String getResult(String formula, int decimalPlace, int roundMethod) {
		double result = getResult(formula);
		if (result == Double.MAX_VALUE)
			return DIVISOR_EQUALS_ZERO;
		else
			return numberAround(result, decimalPlace, roundMethod);
	}

	private double doAnalysis(String formula) {
		double returnValue = 0;
		LinkedList<Integer> stack = new LinkedList<Integer>();

		int curPos = 0;
		String beforePart = "";
		String afterPart = "";
		String calculator = "";
		isRightFormat = true;
		while (isRightFormat
				&& (formula.indexOf('(') >= 0 || formula.indexOf(')') >= 0)) {
			curPos = 0;
			for (char s : formula.toCharArray()) {
				if (s == '(') {
					stack.add(curPos);
				} else if (s == ')') {
					if (stack.size() > 0) {
						beforePart = formula.substring(0, stack.getLast());
						afterPart = formula.substring(curPos + 1);
						calculator = formula.substring(stack.getLast() + 1,
								curPos);
						formula = beforePart + doCalculation(calculator)
								+ afterPart;
						stack.clear();
						break;
					} else {
						System.out.println("��δ�رյ������ţ�");
						isRightFormat = false;
					}
				}
				curPos++;
			}
			if (stack.size() > 0) {
				System.out.println("��δ�رյ������ţ�");
				break;
			}
		}
		if (isRightFormat) {
			returnValue = doCalculation(formula);
		}
		return returnValue;
	}

	/**
	 * Ϊ�����ָ��ţ����ʹ��$�������
	 */
	private double doCalculation(String formula) {
		ArrayList<Double> values = new ArrayList<Double>();
		ArrayList<String> operators = new ArrayList<String>();
		int curPos = 0;
		int prePos = 0;
		for (char s : formula.toCharArray()) {
			if (s == '+' || s == '$' || s == '*' || s == '/' || s == '^') {
				values.add(Double.parseDouble(formula.substring(prePos, curPos)
						.trim()));
				System.out.println("prePos is "+prePos);
				System.out.println("curPos is "+prePos);
				operators.add("" + s);
				prePos = curPos + 1;
			}
			curPos++;
		}
		values.add(Double.parseDouble(formula.substring(prePos).trim()));
		char op;
		for (curPos = operators.size() - 1; curPos >= 0; curPos--) {
			op = operators.get(curPos).charAt(0);
			switch (op) {
			case '*':
				values.add(curPos, values.get(curPos) * values.get(curPos + 1));
				values.remove(curPos + 1);
				values.remove(curPos + 1);
				operators.remove(curPos);
				break;
			case '/':
				if (values.get(curPos + 1).doubleValue() == 0.0)// ����Ϊ��ʱ
					values.add(curPos, new Double(0.0));
				else
					values.add(curPos, values.get(curPos)
							/ values.get(curPos + 1));
				values.remove(curPos + 1);
				values.remove(curPos + 1);
				operators.remove(curPos);
				break;
			case '^':
				if (values.get(curPos + 1) == 2) {// ƽ����
					values.add(curPos, Math.sqrt(values.get(curPos)));
				} else if (values.get(curPos + 1) == 3) {// ������
					values.add(curPos, Math.cbrt(values.get(curPos)));
				}
				values.remove(curPos + 1);
				values.remove(curPos + 1);
				operators.remove(curPos);
				break;
			}
		}
		for (curPos = operators.size() - 1; curPos >= 0; curPos--) {
			op = operators.get(curPos).charAt(0);
			switch (op) {
			case '+':
				values.add(curPos, values.get(curPos) + values.get(curPos + 1));
				values.remove(curPos + 1);
				values.remove(curPos + 1);
				operators.remove(curPos);
				break;
			case '$':
				values.add(curPos, values.get(curPos) - values.get(curPos + 1));
				values.remove(curPos + 1);
				values.remove(curPos + 1);
				operators.remove(curPos);
				break;
			}
		}
		return values.get(0).doubleValue();
	}

	/**
	 * �����ֽ�����������
	 * 
	 * @param dN
	 *            Ҫ�����������
	 * @param decimalPlace
	 *            ����
	 * @param roundMethod
	 *            ��ȥβ���Ĳ��� ��ȡֵ��BigDecimal.ROUND_HALF_UP
	 *            BigDecimal.ROUND_HALF_DOWN���BigDecimal
	 */
	public String numberAround(double dN, int decimalPlace, int roundMethod) {
		BigDecimal bd = new BigDecimal(String.valueOf(dN));
		bd = bd.setScale(decimalPlace, roundMethod);
		return String.valueOf(bd);
	}

	/**
	 * �Ը������ַ�������ģʽƥ��
	 * 
	 * @param str
	 *            Ҫƥ����ַ���
	 * @param regix
	 *            ģʽ
	 * @return ����ƥ�������ɹ�Ϊtrue,����Ϊfalse
	 **/
	public boolean check(String str, String regix) {
		boolean result = false;
		Pattern p = Pattern.compile(regix);
		Matcher m = p.matcher(str);
		result = m.matches();
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	 {
	 FormulaCalculator calculator=new FormulaCalculator();
	 String m=calculator.getResult("(10+3*5+2)^3",2);
	 System.out.println("m is "+m);
	 }
}
