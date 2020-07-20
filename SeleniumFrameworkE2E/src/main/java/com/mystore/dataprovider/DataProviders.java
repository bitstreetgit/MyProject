package com.mystore.dataprovider;

import org.testng.annotations.DataProvider;

import com.mystore.utility.NewExcelLibrary;

public class DataProviders {

	NewExcelLibrary obj = new NewExcelLibrary();

	@DataProvider(name = "data")
	public Object[][] getLoginCredentials() {

		// Total Rows
		int rows = obj.getRowCount("credentials");
		// Total Columns
		int cols = obj.getColumnCount("credentials");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][cols];
		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < cols; j++) {
				data[i][j] = obj.getCellData("credentials", j, i + 2);
			}
		}
		return data;
	}
}
