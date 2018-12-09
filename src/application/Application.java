package application;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.*;

public class Application {

	public static void main(String[] args) throws ParseException {
		Scanner scan = new Scanner(System.in);
		Locale.setDefault(Locale.ENGLISH);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date hoje=new Date();

		System.out.println("Entre com quarto");
		Integer quarto = scan.nextInt();

		System.out.println("Entre com a data de checkin :");
		Date checkin = sdf.parse(scan.next());

		System.out.println("Entre com a data de checkout :");
		Date checkout = sdf.parse(scan.next());
		
		//apos estar funcionando criar uma programaçao defensiva para instanciar o objeto 
		Reserva reserva = new Reserva(quarto,checkin,checkout);
		
		System.out.println("Dados da reserva");
		System.out.println(reserva.toString());
		
		System.out.println("entre com a data para alteração da reserva");
		
		System.out.println("Entre com a data de checkin :");
		Date checkinAlteracao = sdf.parse(scan.next());

		System.out.println("Entre com a data de checkout :");
		Date checkoutAlteracao = sdf.parse(scan.next());
		
		String error= reserva.updateData(checkinAlteracao, checkoutAlteracao);
		
		if (error!=null) {
			System.out.println(error);
			
		}
		else {
			System.out.println("Reserva realizada com sucesso");
			System.out.println("_____________________________");
			System.out.println(reserva.toString());
			
		}
		
				
		
		scan.close();

	}

}
