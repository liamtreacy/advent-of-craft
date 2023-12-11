package food;

import java.time.LocalDate;
import java.util.UUID;
import java.util.function.Supplier;

public record Food(LocalDate expirationDate,
                   Boolean approvedForConsumption,
                   UUID inspectorId) {
    public boolean isEdible(Supplier<LocalDate> now) {
        if (isPastExpiration(now) && isGovernmentApproved()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isPastExpiration(Supplier<LocalDate> now)
    {
        return this.expirationDate.isAfter(now.get());
    }

    private boolean isGovernmentApproved()
    {
        return this.approvedForConsumption && this.inspectorId != null;
    }
}