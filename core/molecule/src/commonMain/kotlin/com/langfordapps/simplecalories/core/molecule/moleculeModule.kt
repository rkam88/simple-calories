package com.langfordapps.simplecalories.core.molecule

import com.langfordapps.simplecalories.core.molecule.internal.MoleculeConfigProvider
import com.langfordapps.simplecalories.core.molecule.internal.MoleculeConfigProviderImpl
import org.koin.dsl.module

val moleculeModule = module {
    factory<MoleculeConfigProvider> { MoleculeConfigProviderImpl }
}
