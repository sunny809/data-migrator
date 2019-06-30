package online.tangbk.common.util.db.provision.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import online.tangbk.common.util.db.provision.model.TaskConfig;

public class TaskConfigLoaderTest {

	private static String prepardData = "[{\"date\":\"20180911\",\"step\":1,\"executeSql\":\"update table set field_1 = '1'\",\"rollbackSql\":\"update table set field_1 = '0'\"},{\"date\":\"20180912\",\"step\":2,\"executeSql\":\"update table set field_1 = '1'\",\"rollbackSql\":\"update table set field_1 = '0'\"},{\"date\":\"20180913\",\"step\":3,\"executeSql\":\"update table set field_1 = '1'\",\"rollbackSql\":\"update table set field_1 = '0'\"}]";
	private TaskConfigLoader loader = new TaskConfigLoader();

	@Test
	public void test() {

		List<TaskConfig> list = loader.load(prepardData);
		assertNotNull(list);
		assertEquals(3, list.size());
		TaskConfig task = list.get(0);
		assertEquals("update table set field_1 = '1'", task.getExecuteSql());
		assertEquals("update table set field_1 = '0'", task.getRollbackSql());
		assertEquals(1, task.getStep());

	}

}
