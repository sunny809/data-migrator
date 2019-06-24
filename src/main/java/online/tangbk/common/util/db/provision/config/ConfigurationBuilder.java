package online.tangbk.common.util.db.provision.config;

import java.io.InputStream;

public interface ConfigurationBuilder {
	Configuration load(InputStream is);
}
