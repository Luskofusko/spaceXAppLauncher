package com.mindera.rocketscience.domain.usecase

import java.util.Date

class GetCurrentTimeInMillisUseCaseImpl: GetCurrentTimeInMillisUseCase {
    override fun execute(): Long {
        return Date().time
    }
}