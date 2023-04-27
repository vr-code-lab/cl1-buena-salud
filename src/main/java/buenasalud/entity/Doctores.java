package buenasalud.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "doctores")
public class Doctores implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_doctor")
	private int ideCita;

	@Column(name = "nom_doctor")
	private String numCita;

	@Column(name = "especialidad_doctor")
	private String fecCita;

	@OneToMany(mappedBy = "c_doctores")
	List<Citas> citas = new ArrayList<Citas>();

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

	public List<Citas> getCitas() {
		return citas;
	}

	public void setCitas(List<Citas> citas) {
		this.citas = citas;
	}

}
