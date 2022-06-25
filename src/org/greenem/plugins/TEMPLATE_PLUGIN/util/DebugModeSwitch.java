package org.greenem.plugins.TEMPLATE_PLUGIN.util;

import java.io.File;

import org.greenem.plugins.TEMPLATE_PLUGIN.data.ProjectInfo;
import org.greenem.plugins.TEMPLATE_PLUGIN.data.References;

public class DebugModeSwitch {
	public static void init() {
		File f = new File(ProjectInfo.pluginConfigDirectory, "enableDebug.dev");
		if(!f.exists()) {
			SimpleLogger.debugOutputEnabled = false;
		}
	}
}
