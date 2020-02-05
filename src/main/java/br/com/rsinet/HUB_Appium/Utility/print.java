package br.com.rsinet.HUB_Appium.Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class print {

	public static String pegaHora() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

	public static String takeSnapShot(WebDriver driver, String nomeDoArquivoImagem) {

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String destino = System.getProperty("user.dir") + "/target/prints/" + nomeDoArquivoImagem + pegaHora() + ".png";

		try {
			FileUtils.copyFile(file, new File(destino));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destino;
	}

}