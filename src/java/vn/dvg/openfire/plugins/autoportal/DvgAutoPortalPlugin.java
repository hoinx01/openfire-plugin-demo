package vn.dvg.openfire.plugins.autoportal;

import org.jivesoftware.admin.AuthCheckFilter;
import org.jivesoftware.openfire.container.Plugin;
import org.jivesoftware.openfire.container.PluginManager;
import org.jivesoftware.openfire.net.SASLAuthentication;
import org.jivesoftware.util.JiveGlobals;
import vn.dvg.openfire.plugins.autoportal.authentication.DvgSaslProvider;
import vn.dvg.openfire.plugins.autoportal.authentication.DvgSaslServer;
import vn.dvg.openfire.plugins.autoportal.restapi.JerseyWrapper;

import java.io.File;
import java.security.Security;
import java.util.Collection;

/**
 * An Openfire plugin that adds the TikiToken SASL mechanism.
 */
public class DvgAutoPortalPlugin implements Plugin
{
    private String secret;

    /** The allowed i ps. */
    private Collection<String> allowedIPs;

    /** The enabled. */
    private boolean enabled;

    private boolean serviceLoggingEnabled;

    /** The http auth. */
    private String httpAuth;

    /** The custom authentication filter */
    private String customAuthFilterClassName;
    @Override
    public void initializePlugin( PluginManager manager, File pluginDirectory )
    {
        AuthCheckFilter.addExclude("autoportal/");
        Security.addProvider( new DvgSaslProvider() );
        SASLAuthentication.addSupportedMechanism( DvgSaslServer.MECHANISM_NAME );
    }

    @Override
    public void destroyPlugin()
    {
        SASLAuthentication.removeSupportedMechanism( DvgSaslServer.MECHANISM_NAME );
        Security.removeProvider( DvgSaslProvider.NAME );
    }
    public String loadAuthenticationFilter(String customAuthFilterClassName) {
        return JerseyWrapper.tryLoadingAuthenticationFilter(customAuthFilterClassName);
    }
    public String getHttpAuth() {
        return httpAuth;
    }

    /**
     * Sets the http auth.
     *
     * @param httpAuth the new http auth
     */
    public void setHttpAuth(String httpAuth) {
        this.httpAuth = httpAuth;
        JiveGlobals.setProperty("plugin.autoportal.httpAuth", httpAuth);
    }
}
