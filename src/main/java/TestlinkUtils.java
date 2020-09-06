import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import br.eti.kinoshita.testlinkjavaapi.constants.ActionOnDuplicate;
import br.eti.kinoshita.testlinkjavaapi.util.TestLinkAPIException;

import java.net.MalformedURLException;
import java.net.URL;

public class TestlinkUtils {
    public static void main(String[] args) {

    }

    public static TestLinkAPI getTestLinkAPI() {
        String url = "http://192.168.6.156:80/testlink/lib/api/xmlrpc/v1/xmlrpc.php";
        String devKey = "e4af1d24407f79d4956010bdf0daa31e";
        TestLinkAPI api = null;
        URL testlinkURL = null;

        try {
            testlinkURL = new URL(url);
        } catch (MalformedURLException mue) {
            mue.printStackTrace(System.err);
            System.exit(-1);
        }

        try {
            api = new TestLinkAPI(testlinkURL, devKey);
        } catch (TestLinkAPIException te) {
            te.printStackTrace(System.err);
            System.exit(-1);
        }
        return api;
    }

    public static int getProjectIDByName(String projectName) {
        return TestlinkUtils.getTestLinkAPI().getTestProjectByName(projectName).getId();
    }

    public static void createTestSuite(Integer projectId, String suiteName, String details, Integer parentId,
                                       Integer order, Boolean checkDuplicatedName,
                                       ActionOnDuplicate actionOnDuplicatedName) {
        TestLinkAPI api = TestlinkUtils.getTestLinkAPI();
        api.createTestSuite(projectId, suiteName, details, parentId, order, checkDuplicatedName, actionOnDuplicatedName);
    }

//    public static void createTestCase(String caseName, Integer testSuiteId, Integer projectId, String authorLogin,
//                                      String summary, String steps, String preconditions, TestCaseStatus status,
//                                      TestImportance importance, ExecutionType execution, Integer order, Integer internalId,
//                                      Boolean checkDuplicatedName, ActionOnDuplicate actionOnDuplicatedName) {
//        TestLinkAPI api = TestlinkUtils.getTestLinkAPI();
//        List<TestCaseStep> steps = new ArrayList<TestCaseStep>();
//
//        api.createTestCase("单日平均车速统计", 31014, 2852,
//                "yuanpengxing", "this is api test",
//                steps, null, null, null, ExecutionType.AUTOMATED, 0,
//                null, true, ActionOnDuplicate.GENERATE_NEW);
//    }

    public static void getCaseById() {

    }

}
