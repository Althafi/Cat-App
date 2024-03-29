package com.example.catapi.data.repository.remote.CatsDTO

import com.example.catapi.domain.model.CatModel
import com.google.gson.annotations.SerializedName

data class CatsDTO(

	@field:SerializedName("CatsDTO")
	val catsDTO: List<CatsDTOItem>
)

data class Weight(

	@field:SerializedName("metric")
	val metric: String,

	@field:SerializedName("imperial")
	val imperial: String
)

data class CatsDTOItem(

	@field:SerializedName("suppressed_tail")
	val suppressedTail: Int,

	@field:SerializedName("wikipedia_url")
	val wikipediaUrl: String,

	@field:SerializedName("origin")
	val origin: String,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("experimental")
	val experimental: Int,

	@field:SerializedName("life_span")
	val lifeSpan: String,

	@field:SerializedName("rare")
	val rare: Int,

	@field:SerializedName("country_codes")
	val countryCodes: String,

	@field:SerializedName("lap")
	val lap: Int,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("short_legs")
	val shortLegs: Int,

	@field:SerializedName("shedding_level")
	val sheddingLevel: Int,

	@field:SerializedName("image")
	val image: Image?,

	@field:SerializedName("dog_friendly")
	val dogFriendly: Int,

	@field:SerializedName("natural")
	val natural: Int,

	@field:SerializedName("rex")
	val rex: Int,

	@field:SerializedName("health_issues")
	val healthIssues: Int,

	@field:SerializedName("hairless")
	val hairless: Int,

	@field:SerializedName("weight")
	val weight: Weight,

	@field:SerializedName("alt_names")
	val altNames: String,

	@field:SerializedName("adaptability")
	val adaptability: Int,

	@field:SerializedName("vocalisation")
	val vocalisation: Int,

	@field:SerializedName("intelligence")
	val intelligence: Int,

	@field:SerializedName("social_needs")
	val socialNeeds: Int,

	@field:SerializedName("country_code")
	val countryCode: String,

	@field:SerializedName("child_friendly")
	val childFriendly: Int,

	@field:SerializedName("temperament")
	val temperament: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("grooming")
	val grooming: Int,

	@field:SerializedName("hypoallergenic")
	val hypoallergenic: Int,

	@field:SerializedName("indoor")
	val indoor: Int,

	@field:SerializedName("energy_level")
	val energyLevel: Int,

	@field:SerializedName("stranger_friendly")
	val strangerFriendly: Int,

	@field:SerializedName("reference_image_id")
	val referenceImageId: String,

	@field:SerializedName("affection_level")
	val affectionLevel: Int,

	@field:SerializedName("cfa_url")
	val cfaUrl: String,

	@field:SerializedName("vcahospitals_url")
	val vcahospitalsUrl: String,

	@field:SerializedName("vetstreet_url")
	val vetstreetUrl: String,

	@field:SerializedName("cat_friendly")
	val catFriendly: Int,

	@field:SerializedName("bidability")
	val bidability: Int
)

data class Image(

	@field:SerializedName("width")
	val width: Int,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("url")
	val url: String,

	@field:SerializedName("height")
	val height: Int
)
fun List<CatsDTOItem>.toModel():List<CatModel> {
	return this.map {

		CatModel(
			name = it.name ,
			temperament = it.temperament ,
			description = it.description ,
			life_span = it.lifeSpan ,
			origin = it.origin ,
			imageUrl = it.image?.url,
			id = it.id
		)
	}
}