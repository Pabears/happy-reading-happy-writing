package heng.shi;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.ExecuteWatchdog;
import org.apache.commons.exec.PumpStreamHandler;

import org.apache.commons.exec.CommandLine;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() throws ExecuteException, IOException {

	}

	public static void main(String[] args) {
		Map<String, String> retmap = new HashMap<String, String>();
		long waitMs = 100000L;
		DefaultExecutor exec = new DefaultExecutor();
		ExecuteWatchdog watchdog = new ExecuteWatchdog(waitMs);
		exec.setWatchdog(watchdog);
		exec.setExitValue(0);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PumpStreamHandler streamHandler = new PumpStreamHandler(out, out);
		exec.setStreamHandler(streamHandler);
		CommandLine cmd = new CommandLine("java -version");
		int retcode = 0;
		String retmsg = "";
		try {
			retcode = exec.execute(cmd);
			retmsg = out.toString("UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("command:" + cmd.toString());
		System.out.println("retcode:" + retcode + "");
		System.out.println("retmsg:" + retmsg);
		retmap.put("retcode", retcode + "");
		retmap.put("retmsg", retmsg);
		System.out.print(retmap);
	}

}
