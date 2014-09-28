package com.bettrhuman.sleepyhead.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

public class Listener extends GuiceServletContextListener {
	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new SleepyHeadModule());
	}
}
