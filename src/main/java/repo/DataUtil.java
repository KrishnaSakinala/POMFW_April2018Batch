package repo;

public class DataUtil {

	public static boolean isTestExecutable(ExcelApiTest eat, String testCaseName) {
		int rows = eat.getRowCount("TestCases");
		for (int rNum = 1; rNum <= rows; rNum++) {
			String tcName = eat.getCellData("TestCases", "TestCaseName", rNum);
			if (tcName.equals(testCaseName)) {
				String runmode = eat.getCellData("TestCases", "RunMode", rNum);
				if (runmode.equals("Y"))
					return true;
				else
					return false;
			}
		}
		return false;
	}
}
