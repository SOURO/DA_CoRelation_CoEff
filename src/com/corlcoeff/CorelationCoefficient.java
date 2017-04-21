package com.corlcoeff;

public class CorelationCoefficient {
	public static void main(String args[]) {
		double x[] = { 5, 2, 8, 4, 6 }, y[] = { 25, 11, 34, 23, 32 };

		double sumX = 0.0, sumY = 0.0, meanX, meanY, /*x_pow2, x_mul_y,*/ x_sub_meanX, y_sub_meanY, x_sub_meanX_pow2, y_sub_meanY_pow2, x_sub_meanX_mul_y_sub_meanY, /*x_pow2_sum=0.0, x_mul_y_sum=0.0,*/ x_sub_meanX_sum=0.0
				, y_sub_meanY_sum=0.0, x_sub_meanX_pow2_sum=0.0, y_sub_meanY_pow2_sum=0.0, x_sub_meanX_mul_y_sub_meanY_sum=0.0;
		double cov_xy, s_x, s_y, r_xy;
		
		int i, n = 5;

		for (i = 0; i < n; i++) {
			sumX += x[i];
			sumY += y[i];
		}

		meanX = sumX / n;
		meanY = sumY / n;

		for (i = 0; i < n; i++) {
			/*x_pow2 = x[i] * x[i];
			x_pow2_sum += x_pow2;
			x_mul_y = x[i] * y[i];
			x_mul_y_sum += x_mul_y;*/
			x_sub_meanX = x[i] - meanX;
			x_sub_meanX_pow2 = x_sub_meanX * x_sub_meanX;
			y_sub_meanY = y[i] - meanY;
			y_sub_meanY_pow2 = y_sub_meanY * y_sub_meanY;
			x_sub_meanX_sum += x_sub_meanX;
			y_sub_meanY_sum += y_sub_meanY;
			x_sub_meanX_pow2_sum += x_sub_meanX_pow2;
			y_sub_meanY_pow2_sum += y_sub_meanY_pow2;
			x_sub_meanX_mul_y_sub_meanY = x_sub_meanX * y_sub_meanY;
			x_sub_meanX_mul_y_sub_meanY_sum += x_sub_meanX_mul_y_sub_meanY;
			System.out.println(x[i] +"  "+ y[i] /*+"  "+ x_pow2 +"  " + x_mul_y +"  "*/ + x_sub_meanX +"  "+ y_sub_meanY +"  "+ x_sub_meanX_pow2 +"  "+  y_sub_meanY_pow2 +"  "+ x_sub_meanX_mul_y_sub_meanY);
		}
		System.out.println(sumX +"  "+ sumY +"  "+ /*x_pow2_sum+"  "+ x_mul_y_sum +"  " +*/ x_sub_meanX_sum +"  "+ y_sub_meanY_sum +"  "+ x_sub_meanX_pow2_sum +"  "+  y_sub_meanY_pow2_sum +"  "+ x_sub_meanX_mul_y_sub_meanY_sum);
		cov_xy = x_sub_meanX_mul_y_sub_meanY_sum/(n-1);
		s_x = Math.sqrt(x_sub_meanX_pow2_sum/(n-1));
		s_y = Math.sqrt(y_sub_meanY_pow2_sum/(n-1));
		r_xy = cov_xy / (s_x * s_y);
		System.out.println(cov_xy +"  " + s_x +"  " +s_y+"  "+ r_xy);
	}
}
