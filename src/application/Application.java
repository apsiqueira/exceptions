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

		if (checkout.after(checkin) && checkin.before(checkout)&& checkin.after(hoje)) {
			Reserva reserva = new Reserva(quarto, checkin, checkout);
			System.out.println("Reservado com sucesso");

			System.out.println(reserva.toString());
			System.out.println("entre com a data para atualização da reserva");

			System.out.println("Entre com a data de checkin :");
			Date checkinAlteracao = sdf.parse(scan.next());

			System.out.println("Entre com a data de checkout :");
			Date checkoutAlteracao = sdf.parse(scan.next());
			
			reserva.updateData(checkinAlteracao, checkoutAlteracao);
			System.out.println("alterção com sucesso");
			System.out.println(reserva.toString());

		} else {
			System.out.println("Erro em realizar a reserva");

		}

		scan.close();

	}

}
