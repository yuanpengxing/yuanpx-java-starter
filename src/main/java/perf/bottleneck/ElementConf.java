package perf.bottleneck;

public class ElementConf {

    public static String getConstantThroughputTimer() {
        return ("      <ConstantThroughputTimer guiclass=\"TestBeanGUI\" testclass=\"ConstantThroughputTimer\" testname=\"Constant Throughput Timer\" enabled=\"true\">\n" +
                "        <doubleProp>\n" +
                "          <name>throughput</name>\n" +
                "          <value>60.0</value>\n" +
                "          <savedValue>0.0</savedValue>\n" +
                "        </doubleProp>\n" +
                "        <intProp name=\"calcMode\">0</intProp>\n" +
                "      </ConstantThroughputTimer>\n" +
                "      <hashTree/>");
    }

    public static String getResponseTimesOverTimeGui(String rtotLoc) {
        return ("      <kg.apc.jmeter.vizualizers.CorrectedResultCollector guiclass=\"kg.apc.jmeter.vizualizers.ResponseTimesOverTimeGui\" testclass=\"kg.apc.jmeter.vizualizers.CorrectedResultCollector\" testname=\"jp@gc - Response Times Over Time\" enabled=\"true\">\n" +
                "        <boolProp name=\"ResultCollector.error_logging\">false</boolProp>\n" +
                "        <objProp>\n" +
                "          <name>saveConfig</name>\n" +
                "          <value class=\"SampleSaveConfiguration\">\n" +
                "            <time>true</time>\n" +
                "            <latency>true</latency>\n" +
                "            <timestamp>true</timestamp>\n" +
                "            <success>true</success>\n" +
                "            <label>true</label>\n" +
                "            <code>true</code>\n" +
                "            <message>true</message>\n" +
                "            <threadName>true</threadName>\n" +
                "            <dataType>true</dataType>\n" +
                "            <encoding>false</encoding>\n" +
                "            <assertions>true</assertions>\n" +
                "            <subresults>true</subresults>\n" +
                "            <responseData>false</responseData>\n" +
                "            <samplerData>false</samplerData>\n" +
                "            <xml>false</xml>\n" +
                "            <fieldNames>true</fieldNames>\n" +
                "            <responseHeaders>false</responseHeaders>\n" +
                "            <requestHeaders>false</requestHeaders>\n" +
                "            <responseDataOnError>false</responseDataOnError>\n" +
                "            <saveAssertionResultsFailureMessage>true</saveAssertionResultsFailureMessage>\n" +
                "            <assertionsResultsToSave>0</assertionsResultsToSave>\n" +
                "            <bytes>true</bytes>\n" +
                "            <sentBytes>true</sentBytes>\n" +
                "            <url>true</url>\n" +
                "            <threadCounts>true</threadCounts>\n" +
                "            <idleTime>true</idleTime>\n" +
                "            <connectTime>true</connectTime>\n" +
                "          </value>\n" +
                "        </objProp>\n" +
                "        <stringProp name=\"filename\">" + rtotLoc + "</stringProp>\n" +
//                "        <stringProp name=\"filename\"></stringProp>\n" +
                "        <longProp name=\"interval_grouping\">500</longProp>\n" +
                "        <boolProp name=\"graph_aggregated\">false</boolProp>\n" +
                "        <stringProp name=\"include_sample_labels\"></stringProp>\n" +
                "        <stringProp name=\"exclude_sample_labels\"></stringProp>\n" +
                "        <stringProp name=\"start_offset\"></stringProp>\n" +
                "        <stringProp name=\"end_offset\"></stringProp>\n" +
                "        <boolProp name=\"include_checkbox_state\">false</boolProp>\n" +
                "        <boolProp name=\"exclude_checkbox_state\">false</boolProp>\n" +
                "      </kg.apc.jmeter.vizualizers.CorrectedResultCollector>\n" +
                "      <hashTree/>");
    }

    public static String getTransactionsPerSecondGui(String tpsLoc) {
        return ("      <kg.apc.jmeter.vizualizers.CorrectedResultCollector guiclass=\"kg.apc.jmeter.vizualizers.TransactionsPerSecondGui\" testclass=\"kg.apc.jmeter.vizualizers.CorrectedResultCollector\" testname=\"jp@gc - Transactions per Second\" enabled=\"true\">\n" +
                "        <boolProp name=\"ResultCollector.error_logging\">false</boolProp>\n" +
                "        <objProp>\n" +
                "          <name>saveConfig</name>\n" +
                "          <value class=\"SampleSaveConfiguration\">\n" +
                "            <time>true</time>\n" +
                "            <latency>true</latency>\n" +
                "            <timestamp>true</timestamp>\n" +
                "            <success>true</success>\n" +
                "            <label>true</label>\n" +
                "            <code>true</code>\n" +
                "            <message>true</message>\n" +
                "            <threadName>true</threadName>\n" +
                "            <dataType>true</dataType>\n" +
                "            <encoding>false</encoding>\n" +
                "            <assertions>true</assertions>\n" +
                "            <subresults>true</subresults>\n" +
                "            <responseData>false</responseData>\n" +
                "            <samplerData>false</samplerData>\n" +
                "            <xml>false</xml>\n" +
                "            <fieldNames>true</fieldNames>\n" +
                "            <responseHeaders>false</responseHeaders>\n" +
                "            <requestHeaders>false</requestHeaders>\n" +
                "            <responseDataOnError>false</responseDataOnError>\n" +
                "            <saveAssertionResultsFailureMessage>true</saveAssertionResultsFailureMessage>\n" +
                "            <assertionsResultsToSave>0</assertionsResultsToSave>\n" +
                "            <bytes>true</bytes>\n" +
                "            <sentBytes>true</sentBytes>\n" +
                "            <url>true</url>\n" +
                "            <threadCounts>true</threadCounts>\n" +
                "            <idleTime>true</idleTime>\n" +
                "            <connectTime>true</connectTime>\n" +
                "          </value>\n" +
                "        </objProp>\n" +
                "        <stringProp name=\"filename\">" + tpsLoc + "</stringProp>\n" +
                "        <longProp name=\"interval_grouping\">1000</longProp>\n" +
                "        <boolProp name=\"graph_aggregated\">false</boolProp>\n" +
                "        <stringProp name=\"include_sample_labels\"></stringProp>\n" +
                "        <stringProp name=\"exclude_sample_labels\"></stringProp>\n" +
                "        <stringProp name=\"start_offset\"></stringProp>\n" +
                "        <stringProp name=\"end_offset\"></stringProp>\n" +
                "        <boolProp name=\"include_checkbox_state\">false</boolProp>\n" +
                "        <boolProp name=\"exclude_checkbox_state\">false</boolProp>\n" +
                "      </kg.apc.jmeter.vizualizers.CorrectedResultCollector>\n" +
                "      <hashTree/>");
    }

    public static String getErrorResultCollector(String ercLoc) {
        return ("      <ResultCollector guiclass=\"ViewResultsFullVisualizer\" testclass=\"ResultCollector\" testname=\"View Results Tree\" enabled=\"true\">\n" +
                "        <boolProp name=\"ResultCollector.error_logging\">true</boolProp>\n" +
                "        <objProp>\n" +
                "          <name>saveConfig</name>\n" +
                "          <value class=\"SampleSaveConfiguration\">\n" +
                "            <time>true</time>\n" +
                "            <latency>true</latency>\n" +
                "            <timestamp>true</timestamp>\n" +
                "            <success>true</success>\n" +
                "            <label>true</label>\n" +
                "            <code>true</code>\n" +
                "            <message>true</message>\n" +
                "            <threadName>true</threadName>\n" +
                "            <dataType>true</dataType>\n" +
                "            <encoding>true</encoding>\n" +
                "            <assertions>true</assertions>\n" +
                "            <subresults>true</subresults>\n" +
                "            <responseData>true</responseData>\n" +
                "            <samplerData>true</samplerData>\n" +
                "            <xml>true</xml>\n" +
                "            <fieldNames>true</fieldNames>\n" +
                "            <responseHeaders>true</responseHeaders>\n" +
                "            <requestHeaders>true</requestHeaders>\n" +
                "            <responseDataOnError>false</responseDataOnError>\n" +
                "            <saveAssertionResultsFailureMessage>true</saveAssertionResultsFailureMessage>\n" +
                "            <assertionsResultsToSave>0</assertionsResultsToSave>\n" +
                "            <bytes>true</bytes>\n" +
                "            <sentBytes>true</sentBytes>\n" +
                "            <url>true</url>\n" +
                "            <fileName>true</fileName>\n" +
                "            <hostname>true</hostname>\n" +
                "            <threadCounts>true</threadCounts>\n" +
                "            <sampleCount>true</sampleCount>\n" +
                "            <idleTime>true</idleTime>\n" +
                "            <connectTime>true</connectTime>\n" +
                "          </value>\n" +
                "        </objProp>\n" +
                "        <stringProp name=\"filename\">" + ercLoc + "</stringProp>\n" +
                "      </ResultCollector>\n" +
                "      <hashTree/>");

    }

    public static String getRightResultCollector() {
        return ("      <ResultCollector guiclass=\"ViewResultsFullVisualizer\" testclass=\"ResultCollector\" testname=\"View Results Tree\" enabled=\"true\">\n" +
                "        <boolProp name=\"ResultCollector.error_logging\">false</boolProp>\n" +
                "        <objProp>\n" +
                "          <name>saveConfig</name>\n" +
                "          <value class=\"SampleSaveConfiguration\">\n" +
                "            <time>true</time>\n" +
                "            <latency>true</latency>\n" +
                "            <timestamp>true</timestamp>\n" +
                "            <success>true</success>\n" +
                "            <label>true</label>\n" +
                "            <code>true</code>\n" +
                "            <message>true</message>\n" +
                "            <threadName>true</threadName>\n" +
                "            <dataType>true</dataType>\n" +
                "            <encoding>false</encoding>\n" +
                "            <assertions>true</assertions>\n" +
                "            <subresults>true</subresults>\n" +
                "            <responseData>false</responseData>\n" +
                "            <samplerData>false</samplerData>\n" +
                "            <xml>false</xml>\n" +
                "            <fieldNames>true</fieldNames>\n" +
                "            <responseHeaders>false</responseHeaders>\n" +
                "            <requestHeaders>false</requestHeaders>\n" +
                "            <responseDataOnError>false</responseDataOnError>\n" +
                "            <saveAssertionResultsFailureMessage>true</saveAssertionResultsFailureMessage>\n" +
                "            <assertionsResultsToSave>0</assertionsResultsToSave>\n" +
                "            <bytes>true</bytes>\n" +
                "            <sentBytes>true</sentBytes>\n" +
                "            <url>true</url>\n" +
                "            <threadCounts>true</threadCounts>\n" +
                "            <idleTime>true</idleTime>\n" +
                "            <connectTime>true</connectTime>\n" +
                "          </value>\n" +
                "        </objProp>\n" +
                "        <stringProp name=\"filename\"></stringProp>\n" +
                "      </ResultCollector>\n" +
                "      <hashTree/>");
    }

    public static String getAggregateReport() {
        return ("      <ResultCollector guiclass=\"StatVisualizer\" testclass=\"ResultCollector\" testname=\"Aggregate Report\" enabled=\"true\">\n" +
                "        <boolProp name=\"ResultCollector.error_logging\">false</boolProp>\n" +
                "        <objProp>\n" +
                "          <name>saveConfig</name>\n" +
                "          <value class=\"SampleSaveConfiguration\">\n" +
                "            <time>true</time>\n" +
                "            <latency>true</latency>\n" +
                "            <timestamp>true</timestamp>\n" +
                "            <success>true</success>\n" +
                "            <label>true</label>\n" +
                "            <code>true</code>\n" +
                "            <message>true</message>\n" +
                "            <threadName>true</threadName>\n" +
                "            <dataType>true</dataType>\n" +
                "            <encoding>true</encoding>\n" +
                "            <assertions>true</assertions>\n" +
                "            <subresults>true</subresults>\n" +
                "            <responseData>true</responseData>\n" +
                "            <samplerData>true</samplerData>\n" +
                "            <xml>true</xml>\n" +
                "            <fieldNames>true</fieldNames>\n" +
                "            <responseHeaders>true</responseHeaders>\n" +
                "            <requestHeaders>true</requestHeaders>\n" +
                "            <responseDataOnError>false</responseDataOnError>\n" +
                "            <saveAssertionResultsFailureMessage>true</saveAssertionResultsFailureMessage>\n" +
                "            <assertionsResultsToSave>0</assertionsResultsToSave>\n" +
                "            <bytes>true</bytes>\n" +
                "            <sentBytes>true</sentBytes>\n" +
                "            <url>true</url>\n" +
                "            <fileName>true</fileName>\n" +
                "            <hostname>true</hostname>\n" +
                "            <threadCounts>true</threadCounts>\n" +
                "            <sampleCount>true</sampleCount>\n" +
                "            <idleTime>true</idleTime>\n" +
                "            <connectTime>true</connectTime>\n" +
                "          </value>\n" +
                "        </objProp>\n" +
                "        <stringProp name=\"filename\"></stringProp>\n" +
                "      </ResultCollector>\n" +
                "      <hashTree/>");
    }

}
