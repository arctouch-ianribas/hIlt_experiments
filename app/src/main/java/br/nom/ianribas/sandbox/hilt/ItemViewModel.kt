package br.nom.ianribas.sandbox.hilt

import androidx.lifecycle.ViewModel
import br.nom.ianribas.sandbox.hilt.repository.DummyRepo
import javax.inject.Inject

class ItemViewModel private constructor(
    private val repo: DummyRepo,
    private val itemText: String
) : ViewModel() {

    val name: String = "viewModel${idGenerator++}"
    val itemContent: String
        get() = repo.getRepoContent(itemText)

    companion object {
        var idGenerator = 0
    }

    class Factory @Inject constructor(private val repo: DummyRepo) {
        fun create(itemText: String): ItemViewModel {
            return ItemViewModel(repo, itemText)
        }
    }
}