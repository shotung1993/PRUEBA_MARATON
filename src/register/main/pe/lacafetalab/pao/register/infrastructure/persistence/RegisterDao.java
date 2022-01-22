package pe.lacafetalab.pao.register.infrastructure.persistence;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pe.lacafetalab.pao.register.domain.RegisterModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@NoArgsConstructor
@Entity(name = "register")
@Table(name = "register")
public class RegisterDao {

    private static final long serialVersionUID = 1L;
    public static final String SEPARATOR = "|";

    @Id
    @Column(name = "ruc")
    private String ruc;

    @Column(name = "razon_social")
    private String razon_social;

    @Column(name = "estado")
    private String estado;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "ubigeo")
    private String ubigeo;

    @Column(name = "departamento")
    private String departamento;

    @Column(name = "provincia")
    private String provincia;

    @Column(name = "distrito")
    private String distrito;


    public RegisterDao(RegisterModel entity) {
        super();
        this.ruc = entity.getRuc();
        this.razon_social = entity.getRazon_social();
        this.estado = entity.getEstado();
        this.direccion = entity.getDireccion();
        this.ubigeo = entity.getUbigeo();
        this.departamento = entity.getDepartamento();
        this.provincia = entity.getProvincia();
        this.distrito = entity.getDistrito();
    }
//
//    private Integer generateOrderView() {
//        if (this.isConsultation.booleanValue()) {
//            return 9999;
//        }
//        return 1000;
//    }
//
//    @Override
//    public Forum toDomain() {
//        return new Forum(new ForumId(this.id), new ForumTitle(this.title),
//                this.sectionIds.stream().map(ForumSectionId::new).collect(Collectors.toList()),
//                new ForumCourseId(this.courseId), new ForumContent(this.content),
//                this.files.stream().map(ForumFile::new).collect(Collectors.toList()),
//                new ForumAuthorId(this.authorId), new ForumFinishAt(this.finishAt),
//                new ForumIsEvaluated(this.isEvaluated), new ForumPublishBefore(this.publishBefore),
//                new ForumPublishAt(this.publishAt), new ForumStatus(this.status),
//                new ForumIsConsultation(this.isConsultation),
//                ForumIsDeleted.create(this.isDeleted), ForumEvaluation.fromValue(this.evaluationTopScore, this.evaluationType),
//                this.filesName.stream().map(ForumFileName::new).collect(Collectors.toList()),
//                this.filesSize.stream().map(ForumFileSize::new).collect(Collectors.toList()),
//                new ForumLastSaveAt(this.lastSaveAt), new ForumOrigen(this.origen),
//                new ForumCanTeacherModifyDate(this.canTeacherModifyDate),
//                new ForumDateAssociate(this.dateAssociate),
//                new ForumTemplateId(this.templateId),
//                new ForumTemplateContentId(this.templateContentId)
//        );
//    }
}
