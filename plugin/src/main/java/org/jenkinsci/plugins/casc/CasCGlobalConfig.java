package org.jenkinsci.plugins.casc;

import hudson.Extension;
import jenkins.model.GlobalConfiguration;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;

/**
 *
 */
@Extension
public class CasCGlobalConfig extends GlobalConfiguration {

    private String configurationPath;

    @DataBoundConstructor
    public CasCGlobalConfig(String pathToFiles) {
        this.configurationPath = pathToFiles;
    }

    public CasCGlobalConfig() {
        load();
    }

    @Override
    public String getDisplayName() {
        return "CasC configuration";
    }

    public String getConfigurationPath() {
        return configurationPath;
    }

    public void setConfigurationPath(String configurationPath) {
        this.configurationPath = configurationPath;
    }

    @Override
    public boolean configure(StaplerRequest req, JSONObject json) throws FormException {
        req.bindJSON(this, json);
        save();
        return super.configure(req, json);
    }

}
