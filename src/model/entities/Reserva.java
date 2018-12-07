package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	private Integer numQuarto;
	private Date checkin;
	private Date checkout;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reserva(Integer numQuarto, Date checkin, Date checkout) {
		this.numQuarto = numQuarto;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getNumQuarto() {
		return numQuarto;
	}

	public void setNumQuarto(Integer numQuarto) {
		this.numQuarto = numQuarto;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public Long duracao() {
		long diff = this.checkout.getTime() - this.checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

	}

	public void updateData(Date checkinAlteracao, Date checkoutAlteracao) {
		Date agora = new Date();
		if (checkinAlteracao.before(agora) || checkoutAlteracao.before(checkinAlteracao)) {
			System.out.println("Erro na alteração da reserva");

		}
		
		else {
			this.checkin = checkinAlteracao;
			this.checkout = checkoutAlteracao;	
			System.out.println("Alterção feita com sucesso");
			
		}



	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Reserva [numQuarto=");
		builder.append(numQuarto);
		builder.append(", checkin=");
		builder.append(sdf.format(this.checkin));
		builder.append(", checkout=");
		builder.append(sdf.format(this.checkout));
		builder.append(" Duração de " + duracao());
		builder.append(" Noites");

		return builder.toString();
	}

}
