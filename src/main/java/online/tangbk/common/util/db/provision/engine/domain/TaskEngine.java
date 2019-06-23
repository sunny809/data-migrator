package online.tangbk.common.util.db.provision.engine.domain;

import java.util.LinkedList;
import java.util.List;

public abstract class TaskEngine {

	protected List<Task> upgradeTaskList = new LinkedList<>();
	protected List<Task> downgradeTaskList = new LinkedList<>();

	protected Task currentTask;

	abstract void execute();

	protected Status getCurrentEngineStatus() {
		return currentTask.status;
	}

	protected Task getCurrentTask() {
		return currentTask;
	}

}
