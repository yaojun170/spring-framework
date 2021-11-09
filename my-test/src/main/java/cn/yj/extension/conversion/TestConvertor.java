package cn.yj.extension.conversion;

import org.junit.Test;
import org.springframework.core.convert.support.DefaultConversionService;

import java.util.Date;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-09
 */
public class TestConvertor {
	@Test
	public void testInt2StringConvertor(){
		DefaultConversionService convert = new DefaultConversionService();
		String convert1 = convert.convert(2892, String.class);
		System.out.println(convert1);
	}

	@Test
	public void testString2Date(){
		DefaultConversionService convert = new DefaultConversionService();
		boolean b = convert.canConvert(String.class, Date.class);
		System.out.println("可以转化："+b);
		Date value = convert.convert("2021-05-28 09:20:50", Date.class);
		System.out.println(value);
	}


}
