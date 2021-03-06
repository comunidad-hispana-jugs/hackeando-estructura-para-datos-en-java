package org.medellinjug.hackings;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

public class HackingMoneys {

	/*
	Use Case: La empresa Software el Coyote S.A le ha ofrecido a sus developers una bonificación
	del 10% del salario por cada mes siempre y cuando realicen un curso o obtengan una certificación.
	Los meses a bonificar son desde febrero a noviembre, la bonificación se pagara en diciembre

	Para los developers que se hagan merecedores a la bonificación cada mes, recibiran una bonificación
	adicional del 100% de su salario

	 */

	public static Long calculateBonusWithDoubles(List<Double> monthlyPercentages, Long salary) {

		Double sumPercentage = 0D;
		for(Double montPercentage:monthlyPercentages){
			sumPercentage = sumPercentage + montPercentage;
		}

		if (sumPercentage.equals( 1 )){ // 1 equals 100%
			sumPercentage = sumPercentage + 1;
		}

		Double bonusValue = sumPercentage*salary;

		return bonusValue.longValue();

	}

	public static Long calculateBonusWithBigDecimal(List<Double> monthlyPercentages, Long salary) {

		BigDecimal sumPercentage = BigDecimal.ZERO;


		for(Double montPercentage:monthlyPercentages){
			BigDecimal bigMontPercentage =  new BigDecimal( montPercentage );
			sumPercentage = sumPercentage.add( bigMontPercentage );
		}

		sumPercentage = sumPercentage.setScale( 1 , RoundingMode.FLOOR);
		BigDecimal sumPercentageONE = BigDecimal.ONE;

		if (sumPercentage.equals( sumPercentageONE )){ // 1 equals 100%
			sumPercentage = sumPercentage.add(  new BigDecimal( 1 ) );
		}

		if (sumPercentage.doubleValue()==1){ // 1 equals 100%
			sumPercentage = sumPercentage.add(  new BigDecimal( 1 ) );
		}

		Double bonusValue = sumPercentage.doubleValue()*salary;

		return bonusValue.longValue();

	}

}
