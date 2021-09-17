package com.hixtrik.periodictable.models

import com.google.gson.annotations.SerializedName

//┌──────────────────────────┐
//│ Created by Taha ARICAN   │
//│ aricantaha06@gmail.com   │            
//│ 15.09.2021               │
//└──────────────────────────┘
data class Element(
    @SerializedName("name") val name: String,
    @SerializedName("appearance") val appearance: String,
    @SerializedName("atomic_mass") val atomic_mass: Double,
    @SerializedName("boil") val boil: Double,
    @SerializedName("category") val category: String,
    @SerializedName("color") val color: String,
    @SerializedName("density") val density: Double,
    @SerializedName("discovered_by") val discovered_by: String,
    @SerializedName("melt") val melt: Double,
    @SerializedName("molar_heat") val molar_heat: Double,
    @SerializedName("named_by") val named_by: String,
    @SerializedName("number") val number: Int,
    @SerializedName("period") val period: Int,
    @SerializedName("phase") val phase: String,
    @SerializedName("source") val source: String,
    @SerializedName("spectral_img") val spectral_img: String,
    @SerializedName("summary") val summary: String,
    @SerializedName("symbol") val symbol: String,
    @SerializedName("xpos") val xpos: Int,
    @SerializedName("ypos") val ypos: Int,
    @SerializedName("shells") val shells: List<Int>,
    @SerializedName("electron_configuration") val electron_configuration: String,
    @SerializedName("electron_configuration_semantic") val electron_configuration_semantic: String,
    @SerializedName("electron_affinity") val electron_affinity: Double,
    @SerializedName("electronegativity_pauling") val electronegativity_pauling: Double,
    @SerializedName("ionization_energies") val ionization_energies: List<Float>,
    @SerializedName("cpk-hex") val cpkhex: String,
    @SerializedName("visibility") val visibility: Boolean?
)
