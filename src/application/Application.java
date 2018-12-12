package application;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.*;
import model.exceptions.DomainExceptions;

public class Application {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Locale.setDefault(Locale.ENGLISH);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.println("Entre com quarto");
			Integer quarto = scan.nextInt();

			System.out.println("Entre com a data de checkin :");
			Date checkin = sdf.parse(scan.next());

			System.out.println("Entre com a data de checkout :");
			Date checkout = sdf.parse(scan.next());

			// apos estar funcionando criar uma programaçao defensiva para instanciar o
			// objeto
			Reserva reserva = new Reserva(quarto, checkin, checkout);

			System.out.println("Dados da reserva");
			System.out.println(reserva.toString());

			System.out.println("entre com a data para alteração da reserva");

			System.out.println("Entre com a data de checkin :");
			Date checkinAlteracao = sdf.parse(scan.next());

			System.out.println("Entre com a data de checkout :");
			Date checkoutAlteracao = sdf.parse(scan.next());

			reserva.updateData(checkinAlteracao, checkoutAlteracao);
			System.out.println(reserva.toString());

			scan.close();

		} catch (ParseException e) {
			System.out.println(e);

		} catch (DomainExceptions e) {
			System.out.println(e.getMessage());

		}

	}

}
