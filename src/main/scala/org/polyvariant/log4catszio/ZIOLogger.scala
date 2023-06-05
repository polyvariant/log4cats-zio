/*
 * Copyright 2023 Polyvariant
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.polyvariant.log4catszio

import org.typelevel.log4cats.Logger
import zio._

object ZIOLogger {

  def instance[R, E]: Logger[ZIO[R, E, *]] =
    new Logger[ZIO[R, E, *]] {

      override def error(message: => String): ZIO[R, E, Unit] = ZIO.logError(message)

      override def warn(message: => String): ZIO[R, E, Unit] = ZIO.logWarning(message)

      override def info(message: => String): ZIO[R, E, Unit] = ZIO.logInfo(message)

      override def debug(message: => String): ZIO[R, E, Unit] = ZIO.logDebug(message)

      override def trace(message: => String): ZIO[R, E, Unit] = ZIO.logTrace(message)

      override def error(
        t: Throwable
      )(
        message: => String
      ): ZIO[R, E, Unit] = ZIO.logErrorCause(message, Cause.die(t))

      override def warn(
        t: Throwable
      )(
        message: => String
      ): ZIO[R, E, Unit] = ZIO.logWarningCause(message, Cause.die(t))

      override def info(
        t: Throwable
      )(
        message: => String
      ): ZIO[R, E, Unit] = ZIO.logInfoCause(message, Cause.die(t))

      override def debug(
        t: Throwable
      )(
        message: => String
      ): ZIO[R, E, Unit] = ZIO.logDebugCause(message, Cause.die(t))

      override def trace(
        t: Throwable
      )(
        message: => String
      ): ZIO[R, E, Unit] = ZIO.logTraceCause(message, Cause.die(t))

    }

}
