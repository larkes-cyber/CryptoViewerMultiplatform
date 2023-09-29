package com.example.snicryptomultiplatform.data.remote.dto

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class CoinDetailDto(
	val symbol: String? = null,
	@SerialName("is_active")
	val isActive: Boolean? = null,
	@SerialName("is_new")
	val isNew: Boolean? = null,
	@SerialName("proof_type")
	val proofType: String? = null,
	@SerialName("first_data_at")
	val firstDataAt: String? = null,
	val description: String? = null,
	val team: List<TeamItem?>? = null,
	@SerialName("links_extended")
	val linksExtended: List<LinksExtendedItem?>? = null,
	val type: String? = null,
	val message: String? = null,
	val tags: List<TagsItem?>? = null,
	@SerialName("last_data_at")
	val lastDataAt: String? = null,
	val whitepaper: Whitepaper? = null,
	@SerialName("org_structure")
	val orgStructure: String? = null,
	@SerialName("hardware_wallet")
	val hardwareWallet: Boolean? = null,
	val name: String? = null,
	@SerialName("development_status")
	val developmentStatus: String? = null,
	@SerialName("hash_algorithm")
	val hashAlgorithm: String? = null,
	val rank: Int? = null,
	val logo: String? = null,
	@SerialName("started_at")
	val startedAt: String? = null,
	val links: Links? = null,
	val id: String? = null,
	@SerialName("open_source")
	val openSource: Boolean? = null
)

@kotlinx.serialization.Serializable
data class LinksExtendedItem(
	val type: String? = null,
	val url: String? = null,
	val stats: Stats? = null
)

@kotlinx.serialization.Serializable
data class TeamItem(
	val name: String? = null,
	val id: String? = null,
	val position: String? = null
)

@kotlinx.serialization.Serializable
data class TagsItem(
	@SerialName("coin_counter")
	val coinCounter: Int? = null,
	@SerialName("ico_counter")
	val icoCounter: Int? = null,
	val name: String? = null,
	val id: String? = null
)

@kotlinx.serialization.Serializable
data class Stats(
	val followers: Int? = null,
	val contributors: Int? = null,
	val stars: Int? = null,
	val subscribers: Int? = null
)

@kotlinx.serialization.Serializable
data class Whitepaper(
	val thumbnail: String? = null,
	val link: String? = null
)

@kotlinx.serialization.Serializable
data class Links(
	val youtube: List<String?>? = null,
	val website: List<String?>? = null,
	val facebook: List<String?>? = null,
	val explorer: List<String?>? = null,
	val reddit: List<String?>? = null,
	@SerialName("source_code")
	val sourceCode: List<String?>? = null
)

