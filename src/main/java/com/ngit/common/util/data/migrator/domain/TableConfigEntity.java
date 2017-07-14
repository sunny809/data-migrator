package com.ngit.common.util.data.migrator.domain;

import org.springframework.stereotype.Component;

@Component
public class TableConfigEntity {

	private String srcTableName;
	private String destTableName;
	private String templateFileName;

	public String getSrcTableName() {
		return srcTableName;
	}

	public void setSrcTableName(String srcTableName) {
		this.srcTableName = srcTableName;
	}

	public String getDestTableName() {
		return destTableName;
	}

	public void setDestTableName(String destTableName) {
		this.destTableName = destTableName;
	}

	public String getTemplateFileName() {
		return templateFileName;
	}

	public void setTemplateFileName(String templateFileName) {
		this.templateFileName = templateFileName;
	}

	@Override
	public String toString() {
		return "ConfigEntity [srcTableName=" + srcTableName + ", destTableName=" + destTableName + ", templateFileName="
				+ templateFileName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destTableName == null) ? 0 : destTableName.hashCode());
		result = prime * result + ((srcTableName == null) ? 0 : srcTableName.hashCode());
		result = prime * result + ((templateFileName == null) ? 0 : templateFileName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TableConfigEntity other = (TableConfigEntity) obj;
		if (destTableName == null) {
			if (other.destTableName != null)
				return false;
		} else if (!destTableName.equals(other.destTableName))
			return false;
		if (srcTableName == null) {
			if (other.srcTableName != null)
				return false;
		} else if (!srcTableName.equals(other.srcTableName))
			return false;
		if (templateFileName == null) {
			if (other.templateFileName != null)
				return false;
		} else if (!templateFileName.equals(other.templateFileName))
			return false;
		return true;
	}

}
