package buenasalud.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "citas")
public class Citas implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cita")
	private int ideCita;

	@Column(name = "num_cita")
	private String numCita;

	@Column(name = "fecha_cita")
	private String fecCita;

	@Column(name = "nom_paciente_cita")
	private String nomPacCit;

	@ManyToOne
	@JoinColumn(name = "id_doctor")
	private Doctores c_doctores;

	public int getIdeCita() {
		return ideCita;
	}

	public void setIdeCita(int ideCita) {
		this.ideCita = ideCita;
	}

	public String getNumCita() {
		return numCita;
	}

	public void setNumCita(String numCita) {
		this.numCita = numCita;
	}

	public String getFecCita() {
		return fecCita;
	}

	public void setFecCita(String fecCita) {
		this.fecCita = fecCita;
	}

	public String getNomPacCit() {
		return nomPacCit;
	}

	public void setNomPacCit(String nomPacCit) {
		this.nomPacCit = nomPacCit;
	}

	public Doctores getC_doctores() {
		return c_doctores;
	}

	public void setC_doctores(Doctores c_doctores) {
		this.c_doctores = c_doctores;
	}

}
