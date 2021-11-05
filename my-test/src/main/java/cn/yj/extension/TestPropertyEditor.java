package cn.yj.extension;

import org.junit.Test;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-11-04
 */
public class TestPropertyEditor {
	@Test
	public void testDatePropertyEditor(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor customDateEditor = new CustomDateEditor(simpleDateFormat, true);
		customDateEditor.setAsText("2021-08-23 09:39:26");
		System.out.println((Date)customDateEditor.getValue());
		System.out.println("=====");
	}

	@Test
	public void testDatePropertyEditor2(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor customDateEditor = new CustomDateEditor(simpleDateFormat, true);
		customDateEditor.setValue(new Date());
		System.out.println(customDateEditor.getAsText());
		System.out.println("=====");
	}
}
