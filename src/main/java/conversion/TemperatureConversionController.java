package conversion;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemperatureConversionController {

	private static final String fahrenheitTemplate = "%s degrees Fahrenheit";
	private static final String celsiusTemplate = "%s degrees Celsius";
	
	
	@RequestMapping("/toFahrenheit")
	public Temperature toFarenheit(@RequestParam(value = "temperature", defaultValue = "0")String temperature){
		double fahrenheit = Double.parseDouble(temperature);
		fahrenheit = ((fahrenheit * 1.8) + 32);
		temperature = Double.toString(fahrenheit);
		return new Temperature(String.format(fahrenheitTemplate, temperature));
	}
	
	@RequestMapping(value = "/toCelsius", method = RequestMethod.GET)
	public @ResponseBody Temperature toCelsius(@RequestParam(value = "temperature", defaultValue = "0")String temperature){
		double celsius = Double.parseDouble(temperature);
		celsius = (celsius - 32) / 1.8;
		temperature = Double.toString(celsius);
		return new Temperature(String.format(celsiusTemplate, temperature));
	}
	
}
