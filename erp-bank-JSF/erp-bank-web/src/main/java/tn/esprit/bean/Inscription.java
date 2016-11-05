package tn.esprit.bean;
import java.net.*;
import java.util.* ;


import org.apache.soap.Constants;
import org.apache.soap.Fault;
import org.apache.soap.SOAPException;
import org.apache.soap.rpc.Call;
import org.apache.soap.rpc.Parameter;
import org.apache.soap.rpc.Response;




public class Inscription  {
	
	
	
	public  String getInscription(String email , String Password, String role) 
	{
		
		String ls_result = "";
		 
		Call call = new Call ();
		call.setTargetObjectURI("http://tempuri.org/");
		call.setMethodName ("ReturnRegister");
		call.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
		 
		// Gestion des paramètres
	Vector params = new Vector ();
		params.addElement (new Parameter("email", String.class, email, null));
		params.addElement (new Parameter("password", String.class, Password, null));
		params.addElement (new Parameter("role", String.class, role, null));
		call.setParams (params);
		
		URL url= null;
		try {
			url = new URL ("http://localhost:5629/WebService1.asmx?WSDL");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		// On invoke la methode HelloUser du WebServices
		Response resp=null;
	
			try {
				resp = call.invoke (url, "http://tempuri.org/ReturnRegister");
			} catch (SOAPException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		if (resp.generatedFault())
		{      Fault fault=resp.getFault();
		ls_result = " Fault code: " + fault.getFaultCode();
		ls_result = " Fault Description: " +fault.getFaultString();
		System.out.println("galta");
		}
		else
		{      Parameter result = resp.getReturnValue();
		ls_result = (String) result.getValue();
		System.out.println("inscription");
		}
		
		return ls_result;
		
	}
	
	
	
	
}
