package org.greenem.plugins.TEMPLATEPLUGIN.util;

import java.io.File;

import org.greenem.plugins.TEMPLATEPLUGIN.data.ProjectInfo;
import org.greenem.plugins.TEMPLATEPLUGIN.data.References;

public class DebugModeSwitch {
	public static void init() {
		File f = new File(ProjectInfo.pluginConfigDirectory, "enableDebug.dev");
		if(!f.exists()) {
			SimpleLogger.debugOutputEnabled = false;
		}
	}
}
