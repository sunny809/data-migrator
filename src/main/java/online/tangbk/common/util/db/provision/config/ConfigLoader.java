package online.tangbk.common.util.db.provision.config;

import java.io.IOException;
import java.io.InputStream;

public interface ConfigLoader {

	public void load(String input) throws IOException;

	public void load(InputStream is) throws IOException;

}
