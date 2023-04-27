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
	private int ideDoc;

	@Column(name = "nom_doctor")
	private String nomDoc;

	@Column(name = "especialidad_doctor")
	private String espDoc;

	@OneToMany(mappedBy = "c_doctores")
	List<Citas> citas = new ArrayList<Citas>();

	public int getIdeDoc() {
		return ideDoc;
	}

	public void setIdeDoc(int ideDoc) {
		this.ideDoc = ideDoc;
	}

	public String getNomDoc() {
		return nomDoc;
	}

	public void setNomDoc(String nomDoc) {
		this.nomDoc = nomDoc;
	}

	public String getEspDoc() {
		return espDoc;
	}

	public void setEspDoc(String espDoc) {
		this.espDoc = espDoc;
	}

	public List<Citas> getCitas() {
		return citas;
	}

	public void setCitas(List<Citas> citas) {
		this.citas = citas;
	}

}
