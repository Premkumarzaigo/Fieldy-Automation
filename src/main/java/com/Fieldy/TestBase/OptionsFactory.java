package com.Fieldy.TestBase;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsFactory {

	
	public ChromeOptions chromeOptions(String... options)
	{
		ChromeOptions option=new ChromeOptions();
		return option.addArguments(options);
	}
	
	public EdgeOptions edgeOptions(String... options)
	{
		EdgeOptions option=new EdgeOptions();
		return option.addArguments(options);
	}
	
	public FirefoxOptions firefoxOptions(String... options)
	{
		FirefoxOptions option=new FirefoxOptions();
		return option.addArguments(options);
	}
}
