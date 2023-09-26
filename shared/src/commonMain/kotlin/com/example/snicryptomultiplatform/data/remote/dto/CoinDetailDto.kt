package com.example.snicryptomultiplatform.data.remote.dto

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class CoinDetailDto(

	@SerialName("symbol")
	val symbol: String? = null,

	@SerialName("is_active")
	val isActive: Boolean? = null,

	@SerialName("is_new")
	val isNew: Boolean? = null,

	@SerialName("proof_type")
	val proofType: String? = null,

	@SerialName("first_data_at")
	val firstDataAt: String? = null,

	@SerialName("description")
	val description: String? = null,

	@SerialName("team")
	val team: List<TeamMember?>? = null,

	@SerialName("links_extended")
	val linksExtended: List<LinksExtendedItem?>? = null,

	@SerialName("type")
	val type: String? = null,

	@SerialName("message")
	val message: String? = null,

	@SerialName("tags")
	val tags: List<TagsItem?>? = null,

	@SerialName("last_data_at")
	val lastDataAt: String? = null,

	@SerialName("whitepaper")
	val whitepaper: Whitepaper? = null,

	@SerialName("org_structure")
	val orgStructure: String? = null,

	@SerialName("hardware_wallet")
	val hardwareWallet: Boolean? = null,

	@SerialName("name")
	val name: String? = null,

	@SerialName("development_status")
	val developmentStatus: String? = null,

	@SerialName("hash_algorithm")
	val hashAlgorithm: String? = null,

	@SerialName("rank")
	val rank: Int? = null,

	@SerialName("logo")
	val logo: String? = null,

	@SerialName("started_at")
	val startedAt: String? = null,

	@SerialName("links")
	val links: Links? = null,

	@SerialName("id")
	val id: String? = null,

	@SerialName("open_source")
	val openSource: Boolean? = null
)