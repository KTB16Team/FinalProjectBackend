package aiin.backend.member.entity;

import aiin.backend.util.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(schema = "profile_images")
public class ProfileImage extends BaseEntity {
	@Id
	@Column(name = "profile_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@Column(nullable = true)
	private String image_file_url;

	@Column(nullable = true)
	private Long image_file_size;

	@Column(nullable = true)
	private String image_file_name;

	@Column(nullable = true)
	private String image_file_extension;
}
