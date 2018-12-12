package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainExceptions;

public class Reserva {
	private Integer numQuarto;
	private Date checkin;
	private Date checkout;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static Date agora = new Date();

	public Reserva(Integer numQuarto, Date checkin, Date checkout) throws DomainExceptions {
		checarDatas(checkin, checkout);
		this.numQuarto = numQuarto;

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

	public void checarDatas(Date checkin, Date checkout) throws DomainExceptions {
		if (checkin.before(agora) && checkout.before(agora)) {
			throw new DomainExceptions("Datas para reservas devem ser futuras");

		}
		this.checkin = checkin;
		this.checkout = checkout;

	}

	public void updateData(Date checkin, Date checkout) throws DomainExceptions {

		if (checkin.before(this.checkin)) {
			throw new DomainExceptions(
					"Erro na da reserva, datas devem ser Futuras, para esta opreção deve usar antecipação de reserva "
							+ "caso haja vaga em aberto no hotel ou desistencia");

		}

		if (checkout.before(checkin)) {
			throw new DomainExceptions("Erro na data de Checkout o mesmo deve ser apos a data de Checkin");

		}

		this.checkin = checkin;
		this.checkout = checkout;

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Reserva : numQuarto=");
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
