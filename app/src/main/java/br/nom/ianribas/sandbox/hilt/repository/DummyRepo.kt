package br.nom.ianribas.sandbox.hilt.repository

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DummyRepo @Inject constructor() {
    fun getRepoContent(text: String) = "repo content for $text"
}