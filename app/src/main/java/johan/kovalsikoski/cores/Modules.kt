package johan.kovalsikoski.cores

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import java.util.*

val mainViewModelModule = module {

    single { Random() }

    viewModel { MainViewModel(get()) }
}