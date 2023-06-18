// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

module rooch_test_proj1::month {
    use rooch_test_proj1::year::Year;
    const EID_DATA_TOO_LONG: u64 = 102;

    struct Month has store, drop, copy {
        year: Year,
        number: u8,
        is_leap: bool,
    }

    public fun new(
        year: Year,
        number: u8,
        is_leap: bool,
    ): Month {
        let month = Month {
            year,
            number,
            is_leap,
        };
        validate(&month);
        month
    }

    fun validate(month: &Month) {
        let _ = month;
    }

    public fun year(month: &Month): Year {
        month.year
    }

    public fun number(month: &Month): u8 {
        month.number
    }

    public fun is_leap(month: &Month): bool {
        month.is_leap
    }

}
