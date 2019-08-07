package vn.dvg.openfire.plugins.autoportal;

import org.jivesoftware.openfire.container.Plugin;
import org.jivesoftware.openfire.container.PluginManager;
import org.jivesoftware.openfire.net.SASLAuthentication;
import vn.dvg.openfire.plugins.autoportal.authentication.DvgSaslProvider;
import vn.dvg.openfire.plugins.autoportal.authentication.DvgSaslServer;

import java.io.File;
import java.security.Security;

/**
 * An Openfire plugin that adds the TikiToken SASL mechanism.
 */
public class DvgAutoPortalPlugin implements Plugin
{
    @Override
    public void initializePlugin( PluginManager manager, File pluginDirectory )
    {
        Security.addProvider( new DvgSaslProvider() );
        SASLAuthentication.addSupportedMechanism( DvgSaslServer.MECHANISM_NAME );
    }

    @Override
    public void destroyPlugin()
    {
        SASLAuthentication.removeSupportedMechanism( DvgSaslServer.MECHANISM_NAME );
        Security.removeProvider( DvgSaslProvider.NAME );
    }
}
