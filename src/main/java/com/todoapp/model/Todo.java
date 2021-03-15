
package com.todoapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * 
 */
@Entity(name = "Todo")
@Table(name = "todo")
@Getter
@Setter
public class Todo {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long todoId;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    private User user;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "curr", length = 10)
    private Date currrentDate = new Date();

    @NotBlank(message = "{warning.todoName.empty}")
    private String todoName;

    @NotNull(message = "{warning.hourToSpend.empty}")
    @DecimalMin(value = "0",message = "{warning.hourToSpend.decimalMin}")
    @Column(nullable= false, precision=9, scale=2)
    @Digits(integer=9, fraction=2)
    private BigDecimal hourToSpend;     
 
}
